 Лабораторна робота 16: Java JNI та СІ 
Проєкт демонструє обчислення середнього значення масиву чисел. Операція реалізована двома способами: засобами Java та через C++. Проєкт налаштований на автоматичну збірку і тестування через GitHub Actions.

Інструкція зі збирання та запуску:
1. Генерація заголовків: `javac -h native-headers -d build/classes/java/main src/main/java/ua/khpi/oop/lab16/NativeMeanCalculator.java`
2. Збірка Native-бібліотеки (Linux):
bash
mkdir -p build/native
clang++ -std=c++17 -shared -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -Inative-headers native/nativecalc.cpp -o build/native/libnativecalc.so
