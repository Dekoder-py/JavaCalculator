# JavaCalculator
Basic Java Calculator (built from scratch)

## Running
### Using Docker:
First time run:
```bash
git clone https://github.com/Dekoder-py/JavaCalculator.git
docker build -t java-calculator JavaCalculator
docker run -it java-calculator
```
Subsequent runs:
```bash
docker run -it java-calculator
```
### No Docker:
Java must be available in the path
```bash
git clone https://github.com/Dekoder-py/JavaCalculator.git
clear
cd JavaCalculator
javac -d out/production src/Main.java
java -cp out/production Main

```
