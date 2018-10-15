#!/usr/bin/python

import sys

with open(sys.argv[1], 'r') as f:
    result = dict()

    for line in f.readlines():
        for word in line.strip().split(' '):
            if word in result:
                result[word] += 1
            else:
                result[word] = 1

    for item in result.items():
        print('{} {}'.format(item[1], item[0]))
