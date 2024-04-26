package example03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    // ■ コレクションのその他の機能
    
    Student takeshi = new Student("剛田武", 1, Student.SEX.MALE, 157.0);
    Student suneo = new Student("骨川スネ夫", 2, Student.SEX.MALE,135.0);
    Student shizuka = new Student("源静香", 3, Student.SEX.FEMALE, 140.0);
    Student nobita = new Student("野比のび太", 4, Student.SEX.MALE,140.0);
    
    
    
    // 5. ソート
    ArrayList<Student> list1 = new ArrayList<>();
    list1.add(takeshi);
    list1.add(suneo);
    list1.add(shizuka);
    list1.add(nobita);
    
    //
    System.out.println("最初の順番");
    for(Student s : list1) {
      System.out.println("名前 : " + s.getName());
    }
    
    // 
    System.out.println("シャッフル後");
    Collections.shuffle(list1); // 順番をシャッフルする
    for(Student s : list1) {
      System.out.println("名前 : " + s.getName());
    }
    
    // 
    System.out.println("ソート後");
    list1.sort(new Comparator<Student>() { // Comparator インターフェースを継承したクラスは非常に短くなるので以下のように直接newしてしまうことがあります。
      @Override
      public int compare(Student s1, Student s2) {
        // 最初の引数が2番目の引数より小さい場合は負の整数、両方が等しい場合は0、最初の引数が2番目の引数より大きい場合は正の整数。
        return Integer.compare(s1.getNumber(), s2.getNumber());
      }
    });
    for(Student s : list1) {
      System.out.println("名前 : " + s.getName());
    }
    
    
    // ***********************************************
    // ★ 演習
    // Mini : リストに入っている生徒を身長順に並べてください。
    // Full : 身長が同じ生徒がいる時は、女性が先になるようにしてください。
    //      : 必要なら Student クラスを変更することもできます。
    //
    // EX   : 取り組んでおられるEXがあれば、残りの時間で作業なさってください。
    // ***********************************************
  }
  
  /**
   * コンパレータインターフェースを継承したクラス
   */
  private static class CustomComparator implements Comparator<Student> {
    
    @Override
    public int compare(Student s1, Student s2) {
      // 最初の引数が2番目の引数より小さい場合は負の整数、両方が等しい場合は0、最初の引数が2番目の引数より大きい場合は正の整数。
      int v1 = s1.getNumber();
      int v2 = s2.getNumber();
      
      if(v1 == v2) {
        return 0;
      }
      
      return (v1 < v2 ? -1 : 1);
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
