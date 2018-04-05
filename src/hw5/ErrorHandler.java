package hw5;

class ErrorHandler extends FileHandler {

    ErrorHandler(String pathFileName){
        super(pathFileName);
    }
    @Override
    void read() {
        System.out.println("Неопознанный файл");
    }
}
