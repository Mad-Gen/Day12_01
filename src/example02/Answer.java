package example02;

import java.util.ArrayList;
import java.util.Collections;

public class Answer {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    Student takeshi = new Student("剛田武", 1);
    Student suneo = new Student("骨川スネ夫", 2);
    Student shizuka = new Student("源静香", 3);
    Student nobita = new Student("野比のび太", 4);
    
    ArrayList<Student> list1 = new ArrayList<>();
    list1.add(takeshi);
    list1.add(suneo);
    list1.add(shizuka);
    list1.add(nobita);
    
    System.out.println();
    for(Student s : list1) {
      System.out.println("名前 : " + s.getName());
    }
    
    System.out.println();
    
    Collections.reverse(list1); // 逆順にする
    for(Student s : list1) {
      System.out.println("名前 : " + s.getName());
    }
    
  }
  
  /**
   * 生徒 クラス
   */
  private static class Student {
    
    private String name = null;
    private int number = -1;
    
    /**
     * コンストラクタ
     * @param _name
     * @param _number
     */
    public Student(String _name, int _number) {
      this.name = _name;
      this.number = _number;
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
  }
}
