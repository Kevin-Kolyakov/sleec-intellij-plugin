# LEGOS-SLEEC: Tool for Formalizing and Analyzing Normative Requirements

## Purpose
We present *LEGOS-SLEEC*, a tool designed to support interdisciplinary stakeholders in specifying normative requirements as <em>SLEEC rules</em> (social, legal, ethical, empathetic, and cultural domain-specific language[^1]), and in analyzing and debugging their well-formedness. *LEGOS-SLEEC* is built using four previously published components (FOL* satisfiability checker LEGOS[^2] SLEEC to FOL* translator[^3], FOL* wellformedness satisfiability checker[^4], and FOL* UNSAT proof analyzer[^4]), which have been shown to be effective and usable across nine case studies[^6]. Reflecting on this experience, we have significantly improved the user interface of *LEGOS-SLEEC* and its diagnostic support, and demonstrate the effectiveness of these improvements using four interdisciplinary stakeholders[^7]. Showcase video URL is [HERE](https://youtu.be/LLaBLGxSi8A).

[^1]: Sinem Getir-Yaman, Charlie Burholt, Maddie Jones, Radu Calinescu, and Ana Cavalcanti, Specification and validation of normative rules for autonomous agents, ETAPS/FASE'23, 2024. Available at: <https://link.springer.com/chapter/10.1007/978-3-031-30826-0_13>.
[^2]: Nick Feng, Lina Marsso, Mehrdad Sabetzadeh, Marsha Chechik, Early Verification of Legal Compliance via Bounded Satisfiability Checking, CAV'23, 2023. Available at: <https://arxiv.org/abs/2209.04052RL>.
[^3]: Nick Feng, Lina Marsso, Sinem Getir-Yaman, Townsend Beverley, Radu Calinescu, Ana Cavalcanti, and Marsha Chechik, Towards a Formal Framework for Normative Requirements Elicitation, ASE/NIER'23, 2023. Available at: <http://www.cs.toronto.edu/~fengnick/pdfs/ase23.pdfRL>.
[^4]: Nick Feng, Lina Marsso, Sinem Getir Yaman, Beverley Townsend, Yesugen Baatartogtokh, Reem Ayad, Victória Oldemburgo de Mello, Isobel Standen, Ioannis Stefanakos, Calum Imrie, Genaina Rodrigues, Ana Cavalcanti, Radu Calinescu, and Marsha Chechik, Analyzing and Debugging Normative Requirements via Satisfiability Checking, ICSE'24, 2024. Available at: <https://arxiv.org/abs/2401.05673>.
[^5]: Nick Feng, Lina Marsso, and Marsha Chechik, Diagnosis via Proofs of Unsatisfiability for First-Order Logic with Relational Objects, ASE'24, 2024. Available at: <https://www.arxiv.org/pdf/2409.09223>.
[^6]: Kevin Kolyakov, Lina Marsso, Nick Feng, Junwei Quan, and Marsha Chechik, LEGOS-SLEEC: Tool for Formalizing and Analyzing Normative Requirements, ICSE/DEMO'25, 2025. Available at: <URL>.

## Provenance

## Setup

This guide explains how to install the Sleec plugin in your IntelliJ IDEA environment.

---

### Minimum System Requirements

#### Hardware
- **Performance**: Modern multi-core CPU
- **Memory**: At least 4 GB of free RAM (8 GB recommended if using the Virtual Image method)
- **Storage**: 10 GB of available disk space
- **Device Type**: No special hardware requirements; GPU acceleration is not needed.

#### Operating System
- **Windows**: Windows 10 or later
- **macOS**: macOS 12.0 or later
- **Linux**: Two latest Ubuntu LTS versions

---

### Installation Instructions

#### Method 1: Install from Github Repository

##### Step 1: Download IntelliJ and Python
1. Download and install IntelliJ IDEA 2021.3.3. You can get the Community Edition for free when you scroll down [here](https://www.jetbrains.com/idea/download/other.html).
2. Download and install Python from the official website [here](https://www.python.org/downloads/).
3. Make sure to have git installed [here](https://git-scm.com/downloads).

##### Step 2: Clone the Repository
1. Launch IntelliJ IDEA.
2. Click on **Get from VCS**.
3. Enter the following URL to clone the repository:
   ```
   https://github.com/Kevin-Kolyakov/sleec-intellij-plugin.git
   ```
4. Wait for the files to be configured.

##### Step 3: Configure and Run the Plugin
1. In the **Current File** dropdown menu, change the run configuration to **Run Plugin**.
2. Run the program. Note: Initial errors may occur; these are normal and only happen the first time.

##### Step 4: Install Prerequisites
Ensure you have the following prerequisites installed before running the Sleec IntelliJ Plugin:
1. Python 3.5 or later.
   ```
   pip install z3-solver
   ```
   ```
   pip install pysmt
   ```
   ```
   pip install ordered-set
   ```
   ```
   pip install textx
   ```
   ```
   pip install termcolor
   ```

##### Step 5: Access the Sleec Template
1. In the File tab, click on New, then Project, then select the **Sleec Templates** and click next to access all the example files.
2. Follow the instructions provided in the ReadMe file within the template for further guidance.
3. To run the Sleec files in the template, click on any of the icons in the top right corner of the screen and select a SLEEC file.

##### Step 6: Update the Project
1. Open IntelliJ IDEA and navigate to the **Terminal** tab at the bottom of the screen.
2. Ensure you are in the project's root directory. If not, navigate to it using:
   ```
   cd path/to/your/sleec-intellij-plugin
   ```
3. Pull the latest updates from the repository by running:
   ```
   git pull origin master
   ```
4. Wait for the project to update and reconfigure if necessary.

---

#### Method 2: Install from JetBrains Marketplace
1. Download and install IntelliJ IDEA 2021.3.3. You can get the Community Edition for free when you scroll down [here](https://www.jetbrains.com/idea/download/other.html).
2. Download and install Python from the official website [here](https://www.python.org/downloads/).
3. Install the following Python packages:
   ```
   pip install z3-solver
   ```
   ```
   pip install pysmt
   ```
   ```
   pip install ordered-set
   ```
   ```
   pip install textx
   ```
   ```
   pip install termcolor
   ```
5. Open **IntelliJ IDEA**.
6. Navigate to **File > Settings > Plugins** (or **Preferences > Plugins** on macOS).
7. In the **Plugins** settings, click on the **Marketplace** tab.
8. Search for `Sleec` in the search bar.
9. Locate the Sleec plugin in the results and click **Install**.
10. Restart IntelliJ IDEA when prompted.
11. In the File tab, click on New, then Project, then select the **Sleec Templates** and click next to access all the example files.
12. To run the Sleec files in the template, click on any of the icons in the top right corner of the screen and select a SLEEC file.

Your Sleec plugin is now ready to use!

---

#### Method 3: Install from a Virtual Image (OVA File)

1. Download the Sleec `.ova` file from the official repository or distribution source. [Download the `.ova` file here](https://drive.google.com/file/d/1XO-Cd-Mr-6F4WM2hjopmf77gPmitK_5i/view?usp=sharing)
2. Install a virtual machine software such as **VirtualBox**:
   - [Download VirtualBox](https://www.virtualbox.org/)
3. Open your virtual machine software and select the option to **Import Appliance** or **Import Virtual Machine**.
4. Browse to the downloaded `.ova` file and follow the prompts to import it.
5. Once the virtual machine is imported, adjust the hardware settings (e.g., RAM, CPU) as needed to match your system.
6. Start the virtual machine.
7. The virtual machine will load an environment with IntelliJ IDEA pre-configured with the Sleec plugin.
8. To launch IntelliJ IDEA in the Ubuntu environment, open the terminal and run:
   ```bash
   intellij-idea-community
   ```
9. If prompted for a password in the virtual machine, use:
   ```
   changeme
   ```

Your Sleec plugin is now ready to use within the virtual machine!

---

### Verifying Installation

To ensure the Sleec plugin is installed correctly:
1. Open IntelliJ IDEA.
2. Create or open a project.
3. Navigate to **File > Settings > Plugins** (or **Preferences > Plugins** on macOS) and confirm that `Sleec` appears in the **Installed** tab.

If the plugin is installed successfully, you should see Sleec-specific features (e.g., syntax highlighting, code completion, or tool windows) in your IDE when opening a .sleec file.

---

### Troubleshooting

If you encounter issues:
- Verify that your IntelliJ IDEA version is compatible with the Sleec plugin.
- Ensure you restarted IntelliJ IDEA after installation.
- Check the plugin logs in **Help > Show Log in Explorer/Finder** for detailed error messages.
- Visit the plugin's [GitHub Issues page](https://github.com/Kevin-Kolyakov/sleec-intellij-plugin/issues) for community support.

# Usage

Below, we describe the steps to reproduce our evaluation. To do so, you will need to install the previous version of the tool to replicate our comparison using the four case studies available in [the case-study folder](case-studies/).

## Install and launch the previous tool 
1. Install the previous version of the tool by following the instructions here: https://github.com/NickF0211/LEGOs
2. Launch the previous tool: 
  ```
   python3 sleecFrontEnd.py
  ```
   sometimes you might need to use instead:
  ```
   python sleecFrontEnd.py
  ```
3. To verify that the previous tool is correctly installed, click on 
  ```
check redundancy
  ```
and ensure that it displays a diagnostic.

## Reproduce our experiments 

### Checking Situational Conflicts
1. Copy the `SAFESCADE.sleec` definitions and rules from [here](case-studies/SAFESCADE.sleec) to the previous tool IDE.
2. Check for situational conflicts by clicking on `check situational conflict`.
3. Install and launch our new tool LEGOS-SLEEC, following the instructions the [installation instructions](#installation-instructions).
4. Click on the situational conflict logo as shown below:  
   ![Situational Conflict Button](/img/s-logo.png "Check situational conflict")
5. You can now compare the diagnostics generated by the two versions of the tool. Refer to the image below to see the expected outcomes:  
   ![Situational Conflict Comparison](/img/s-conflict-comparison.png "Compare the situational conflict diagnostics generated by our tool with those produced by the previous version.")  
   Note that the previous version of the tool displayed all possible conflicts at once, which was overwhelming for stakeholders. In contrast, the new version displays one conflict at a time. Once the first conflict is resolved, the next one is shown.  
6. To resolve the first issue, edit the rule R4 to become:
  ```
   R4 when UserDriving then not InformUser unless ({informationImportant} or (({hearRateVariability} = low) and ({eyeMovements} = low)))
  ```
Then, check again to ensure the conflict between R1_2 and R4 is resolved. Stakeholders can continue this process iteratively until no situational conflicting rules remain.

### Checking Insufficiency
1. Copy the `SAFESCADE.sleec` definitions and rules from [here](case-studies/SAFESCADE.sleec) to the previous tool IDE.
2. On the previous tool, check for insufficiency by clicking on `check concern`.
3. On our new tool, click on the concern logo as shown below:  
   ![Checking Insufficiency Button](/img/concern-logo.png "Checking Insufficiency")
4. You can now compare the diagnostics generated by the two versions of the tool. Refer to the image below to see the expected outcomes:  
   ![Insufficiency diagnostic comparison](/img/concern-comparison.png "Compare the insufficiency diagnostics generated by our tool with those produced by the previous version.")  
   Note that the previous version of the tool displayed all the raised concerns at once, which was overwhelming for stakeholders. In contrast, the new version displays one concern at a time. Once the first concern is resolved, the next one is shown.
   
You can follow these two processes ([Checking Situational Conflicts](#checking-situational-conflicts) and [Checking Insufficiency](#checking-insufficiency)) to reproduce all our results using the four case studies available in [the case-study folder](case-studies/).


---

Thank you for using the Sleec IntelliJ Plugin!

