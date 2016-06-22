#!/bin/bash
mysql -u root -pmysql << EOF
use mysql;
show tables;
EOF

