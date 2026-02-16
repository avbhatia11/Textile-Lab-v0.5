# Textile-Lab-v0.5
Java Fabric Comparison Engine for Textile Engineering

Java app for NC State Textiles

[![GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new?hide_repo_select=true&ref=.devcontainer&repo=YOURUSERNAME/Textile-Lab-v0.5)

## Live Demo 
Click "Code" then "Codespaces" then "Create codespace on main". Run in browser:
1. Terminal: javac .java
2. ./TextileLabMain (or java TextileLabMain)

Paste for scores:
Fabric 1 Warp: 0.04 1.20 35
Fabric 1 Weft: 0.045 1.20 32
Fabric 2 Warp: 0.035 1.15 33
Fabric 2 Weft: 0.04 1.15 30


Features:
- Yarn.tex(): π r^2 * density (textile physics)
- GSM/Cover/Comfort: Industry formulas
- compareTo() and recommendations

Sample Output:

FABRIC BATTLE RESULTS
FABRIC 1:
Fabric Analysis:
  Warp: warp (15.1 tex, 35 ends/in)
  Weft: weft (19.1 tex, 32 picks/in)
  Weight: 289 gsm (light/medium/heavy)
  Cover: 110% (open/tight)
  Comfort: 34/100
  Use case: jacket/upholstery

FABRIC 2:
Fabric Analysis:
  Warp: warp (11.1 tex, 33 ends/in)
  Weft: weft (14.5 tex, 30 picks/in)
  Weight: 203 gsm (light/medium/heavy)
  Cover: 110% (open/tight)
  Comfort: 45/100
  Use case: jacket/upholstery

COMPARISON:
Fabric 1 vs 2: HEAVIER (289gsm vs 202gsm)
Fabric 2 vs 1: LIGHTER (202gsm vs 289gsm)
