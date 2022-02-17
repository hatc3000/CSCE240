#Ryan Capron

main: Shape.o Circle.o Rectangle.o Triangle.o
	g++ ./OOGeometricPropertyCalculator.cpp $^ -o main.exe
	./main.exe
Shape.o: 
	g++ -c ./headers/Shape.h ./implem/Shape.cpp 
Circle.o: 
	g++ -c ./headers/Circle.h ./implem/Circle.cpp 
Rectangle.o: 
	g++ -c ./headers/Rectangle.h ./implem/Rectangle.cpp
Triangle.o: 
	g++ -c ./headers/Triangle.h ./implem/Triangle.cpp



