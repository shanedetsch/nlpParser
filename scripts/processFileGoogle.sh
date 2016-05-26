while read line; do echo $line | syntaxnet/demo.sh | grep -v "INFO"  >> ../../rsdets1/scripts/processFilenlp.txt; done < ../../rsdets1/scripts/processFile.txt
