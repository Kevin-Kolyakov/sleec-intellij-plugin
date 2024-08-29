package com.example.sleeclanguageextension;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SleecModuleBuilder extends ModuleBuilder {

    private static final String TEMPLATE_ZIP = "/Templates/legos-sleec-main.zip";

    @Override
    public void setupRootModel(@NotNull ModifiableRootModel model) {
        // Ensure content entry path is set
        String contentEntryPath = getContentEntryPath();
        if (contentEntryPath == null) {
            throw new IllegalStateException("Content entry path is not defined.");
        }

        // Set up content entry
        VirtualFile root = LocalFileSystem.getInstance().refreshAndFindFileByPath(contentEntryPath);
        if (root != null) {
            model.addContentEntry(root);

            try {
                extractTemplate(Paths.get(root.getPath()));
            } catch (IOException e) {
                throw new RuntimeException("Failed to extract project template", e);
            }
        }
    }

    @Override
    public ModuleType<?> getModuleType() {
        return SleecModuleType.getInstance();
    }


    @Override
    public String getContentEntryPath() {
        return getModuleFileDirectory();
    }

    private void extractTemplate(Path destination) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(TEMPLATE_ZIP);
             ZipInputStream zis = new ZipInputStream(is)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                Path newPath = destination.resolve(entry.getName());
                if (entry.isDirectory()) {
                    Files.createDirectories(newPath);
                } else {
                    Files.createDirectories(newPath.getParent());
                    Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);
                }
                zis.closeEntry();
            }
        }
    }
}
