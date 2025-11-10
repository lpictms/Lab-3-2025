import functions.*;

public class Main {
    public static void main(String[] arg) throws InappropriateFunctionPointException {
        System.out.println("==Тестирование двусвязного списка==");
        TabulatedFunction func = new LinkedListTabulatedFunction(1, 5.6, 8);
        for (int i =0; i < func.getPointsCount(); i++)
            func.setPointY(i, func.getPointX(i)*1.2);

        System.out.println("Функиця: y=1.2x");
        func.outFunction();

        System.out.println("Проверка удаления точки с индексом 3");
        func.deletePoint(3);
        func.outFunction();

        System.out.println("Проверка добавления точки (3, 4)");
        func.addPoint(new FunctionPoint(3.0, 4.0));
        func.outFunction();

        System.out.println("Проверка установки точки (2.2, 5) на позицию с индексом 2");
        func.setPoint(2, new FunctionPoint(2.2, 5));
        func.outFunction();

        System.out.println("Проверка getFunctionValue");
        for (double i = -1; i < 3; i += 0.8) {
            System.out.printf("(%.2f, %.2f) ", i, func.getFunctionValue(i));
            System.out.println();
        }

        System.out.println("==Тестирование исключений==");

        System.out.println("Некорректное создание (левая граница больше правой)");
        try {
            TabulatedFunction testFunc = new ArrayTabulatedFunction(34, 3, 8);
            System.out.println("без ошибок");
        }catch (IllegalArgumentException e){
            System.out.println("Error " + e.getMessage());
        }

        System.out.println("обращение к точке с несуществующим индексом");
        try {
            func.getPoint(100);
            System.out.println("Без ошибок");
        }catch (FunctionPointIndexOutOfBoundsException e){
            System.out.println("Error " + e.getMessage());
        }

        System.out.println("точка нарушает порядок возрастания");
        try {
            func.setPoint(2, new FunctionPoint(30,2));
            System.out.println("без ошибок");
        }catch (InappropriateFunctionPointException e){
            System.out.println("Error " + e.getMessage());
        }

        try{
            TabulatedFunction testFunc2 = new ArrayTabulatedFunction(0,2,3);
            testFunc2.deletePoint(0);
            testFunc2.deletePoint(0);
            testFunc2.deletePoint(0);
            System.out.println("без ошибок");
        }catch (IllegalStateException e){
            System.out.println("Error " + e.getMessage());
        }


    }
}
