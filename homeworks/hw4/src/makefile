#Ryan Capron

main: BaseEmail.o Gmail.o Outlook.o
	g++ -std=c++11 ./EmailInformationExtractor.cpp $^ -o main.exe
	./main.exe
	make clean
BaseEmail.o: 
	g++ -c  ./headers/BaseEmail.h ./implem/BaseEmail.cpp 
Gmail.o: 
	g++ -c ./headers/Gmail.h ./implem/Gmail.cpp 
Outlook.o: 
	g++ -c ./headers/Outlook.h ./implem/Outlook.cpp
clean: 
	rm *.o
	rm *.exe
	rm headers/*.h.gch