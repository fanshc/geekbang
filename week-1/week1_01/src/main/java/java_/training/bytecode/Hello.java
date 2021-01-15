package java_.training.bytecode;

public class Hello {
    private int [] ints = new int[]{1,3,5,7,9};
    private String [] strings = new String[]{"1","3","5","7","9"};
    public int add(int num1, int num2){
        return num1 + num2;
    }
    public int jian(int num1, int num2){
        return num1 - num2;
    }
    public int cheng(int num1, int num2){
        return num1 * num2;
    }
    public int chu(int num1, int num2){
        if(num2 == 0 ){
            throw new RuntimeException("分母不能为零");
        }
        return num1/num2;
    }
    public int condition(int num1, int num2){
        if(num1 > num2){
            return num1;
        }
        return num2;
    }
    public double count(){
        double result = 0d;
        for(int number : this.ints){
            result += number;
        }
        return result;
    }
}
