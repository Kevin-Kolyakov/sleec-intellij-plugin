# Sleec IntelliJ Plugin ReadMe

## Installation Instructions

### Step 1: Download IntelliJ and Python
1. Download and install IntelliJ IDEA. You can get the Community Edition for free [here](https://www.jetbrains.com/idea/download/?section=windows).
2. Download and install Python from the official website [here](https://www.python.org/downloads/).

### Step 2: Clone the Repository
1. Launch IntelliJ IDEA.
2. Click on **Get from VCS**.
3. Enter the following URL to clone the repository:
   ```
   https://github.com/Kevin-Kolyakov/sleec-intellij-plugin.git
   ```
4. Wait for the files to be configured.

### Step 3: Configure and Run the Plugin
1. In the **Current File** dropdown menu, change the run configuration to **Run Plugin**.
2. Run the program. Note: Initial errors may occur; these are normal and only happen the first time.

### Step 4: Install Prerequisites
Ensure you have the following prerequisites installed before running the Sleec IntelliJ Plugin:
1. Python 3.5 or later.
2. z3-solver with Python bindings (if pip does not work, use pip3):
   ```
   pip install z3-solver
   ```
3. pysmt for symbolic mathematics:
   ```
   pip install pysmt
   ```
4. OrderedSet library:
   ```
   pip install ordered-set
   ```
5. TextX:
    ```
   pip install textx
   ```

### Step 5: Access the Sleec Template
1. In the project tab, click on the **default Sleec Template** to access all the necessary scripts and example files.
2. Follow the instructions provided in the ReadMe file within the template for further guidance.
3. To run the Sleec files in the template, click on any of the icons in the top right corner of the screen and select a SLEEC file.

### Step 6: Update the Project
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

Enjoy using the Sleec IntelliJ Plugin!

---
