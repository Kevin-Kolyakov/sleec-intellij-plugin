import sys
import os
from os.path import dirname, join
import sys
from os.path import dirname, join

sys.path.append(join(dirname(__file__), "Analyzer"))

import idlelib.colorizer as ic
import idlelib.percolator as ip
import re
from sleecParser import check_input_red, check_input_conflict, check_input_concerns, check_input_purpose
from SleecNorm import check_situational_conflict

# Add the directory containing the script to the Python path
script_dir = dirname(__file__)
sys.path.append(script_dir)

# Print sys.path for debugging purposes
print("sys.path:", sys.path)

# Ensure the directory containing `sleecParser` is in `sys.path`
sleec_dir = join(script_dir, 'Analyzer')  # Adjust this to the correct path
sys.path.append(sleec_dir)

from sleecParser import check_input_red, check_input_conflict, check_input_concerns, check_input_purpose
from SleecNorm import check_situational_conflict

def read_model_file(file_path):
    with open(file_path, 'r') as file:
        return file.read()

def check_concern(cur_text):
    response = check_input_concerns(cur_text)
    print(response)

if __name__ == "__main__":
    import argparse
    parser = argparse.ArgumentParser(description="Process a SLEEC file.")
    parser.add_argument("file_path", help="Path to the SLEEC file to be checked.")
    args = parser.parse_args()

    check_concern(read_model_file(args.file_path))
