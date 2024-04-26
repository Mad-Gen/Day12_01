package example03;

import java.util.ArrayList;
import java.util.Comparator;

public class Answer {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    Student takeshi = new Student("剛田武", 1, Student.SEX.MALE, 157.0);
    Student suneo = new Student("骨川スネ夫", 2, Student.SEX.MALE,135.0);
    Student shizuka = new Student("源静香", 3, Student.SEX.FEMALE, 140.0);
    Student nobita = new Student("野比のび太", 4, Student.SEX.MALE,140.0);
    
    ArrayList<Student> list1 = new ArrayList<>();
    list1.add(takeshi);
    list1.add(suneo);
    list1.add(shizuka);
    list1.add(nobita);
    
    System.out.println("ソート後");
    
    list1.sort(new Comparator<Student>() { 
      @Override
      public int compare(Student s1, Student s2) {
        int comp = Double.compare(s1.getHeight(), s2.getHeight());
        
        if(comp == 0) {
          if(s1.getSex() == Student.SEX.MALE && s2.getSex() == Student.SEX.FEMALE) {
            return 1;
          }else if(s1.getSex() == Student.SEX.FEMALE && s2.getSex() == Student.SEX.MALE) {
            return -1;
          }else{
            return 0;
          }
        }
        
        return comp; 
      }
    });
    
    for(Student s : list1) {
      System.out.println("名前 : " + s.getName());
    }
    
  }
  
  /**
   * 生徒 クラス
   */
  private static class Student {
    
    public enum SEX{
      MALE, FEMALE, UNDEFINED
    }
    
    
    private String name = null;
    private SEX sex = SEX.UNDEFINED;

    private int number = -1;
    private double height = 0;
    
    /**
     * コンストラクタ
     * @param _name
     * @param _number
     * @param _sex
     * @param _height
     */
    public Student(String _name, int _number, SEX _sex, double _height) {
      this.name = _name;
      this.number = _number;
      this.sex = _sex;
      this.height = _height;
    }
    
    /**
     * 名前を取得
     * @return
     */
    public String getName() {
      return name;
    }
    
    /**
     * 出席番号
     * @return
     */
    public int getNumber() {
      return number;
    }
    
    /**
     * 性別
     * @return
     */
    public SEX getSex() {
      return sex;
    }

    /**
     * 身長
     * @return
     */
    public double getHeight() {
      return height;
    }
  }
}
