#!/bin/bash

# Check if the folder name is provided as an argument
if [ -z "$1" ]; then
  echo "Usage: $0 folder_name"
  exit 1
fi

FOLDER_PATH="$(pwd)/src/$1"
FILE1="demo.txt"
FILE2="test.txt"
FILE3="Solver.java"
CONTENT1=""
CONTENT2=$(cat <<EOF
package $1;

import util.Input;
import util.Utility;

import java.io.IOException;
import java.util.List;

public class Solver {

    public static void main(String[] args) {
        try {
            List<String> inputs = Utility.readLine("$1", Input.TEST);
            for (String s: inputs) {
                System.out.println(solvePart2(s));
            }
        } catch (IOException e) {
            System.out.println("Error while reading input file: " + e);
        } catch (Exception e) {
            System.out.println("Error while executing code: " + e);
        }
    }

    public static int solvePart1(String s) {
        int a = 0;
        return a;
    }

    public static int solvePart2(String s) {
        int a = 0;
        return a;
    }
}

EOF
)

mkdir -p "$FOLDER_PATH"
echo "$CONTENT1" > "$FOLDER_PATH/$FILE1"
echo "$CONTENT1" > "$FOLDER_PATH/$FILE2"
echo "$CONTENT2" > "$FOLDER_PATH/$FILE3"

echo "Folder and files created successfully in $FOLDER_PATH!"
