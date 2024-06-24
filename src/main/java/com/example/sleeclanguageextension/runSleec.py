import sys
from os.path import dirname, join

sys.path.append(join(dirname(__file__), "Analyzer"))

import idlelib.colorizer as ic
import idlelib.percolator as ip
import re
from sleecParser import check_input_red, check_input_conflict, check_input_concerns, check_input_purpose
from SleecNorm import check_situational_conflict


def read_model_file(file_path):
    with open(file_path, 'r') as file:
        return file.read()


def check_concern(cur_text):
    response = check_input_concerns(cur_text)
    print(response)


check_concern(read_model_file("C:\\Users\\kevin\\IdeaProjects\\SleecTest\\src\\BSN\\BSN.sleec"))
