#!/bin/bash

if [ -d "task1-bash" ]; then
  rm -rf task1-bash
fi
mkdir task1-bash

cp ./dat103-h24-bash/jurassicParkCast.txt task1-bash/cast.txt

ls task1-bash

echo "------------------------------------------------"

tail -n +2 task1-bash/cast.txt | sort -t',' -k5 -n

echo "------------------------------------------------"

awk -F',' '$1 ~ /^L/ || $2 ~ /^L/' task1-bash/cast.txt

echo "------------------------------------------------"

grep ',F,' task1-bash/cast.txt >task1-bash/women.txt

cat task1-bash/women.txt

echo "------------------------------------------------"

grep ',M,' task1-bash/cast.txt >task1-bash/men.txt

cat task1-bash/men.txt

echo "------------------------------------------------"

for file in task1-bash/*.txt; do
  cp "$file" "${file%.txt}-1.txt"
  cp "$file" "${file%.txt}-2.txt"
done

wc task1-bash/*
