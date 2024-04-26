package example01;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 */
public class Main {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    // 様々なデータ構造（コレクション）
    // 大量のデータを扱いたい時に使います。
    
    // 今まで使ってきた配列は、サイズを決めた後は変更できません。
    Student takeshi = new Student("剛田武", 1);
    Student suneo = new Student("骨川スネ夫", 2);
    Student shizuka = new Student("源静香", 3);
    Student nobita = new Student("野比のび太", 4);
    
    Student[] students = new Student[3];
    students[0] = takeshi;
    students[1] = suneo;
    students[2] = shizuka;
    //students[3] = nobita; // 配列外アクセスのためエラーとなる。
    
    
    // たいていのプログラムでは固定長の配列では困ることが多いので、コレクションクラスを使います。
    // よく使うコレクションを紹介します。
    
    // ArrayList 
    // ● 「伸び縮み可能な配列」と考えてOKです。
    //
    // 色々な書き方
    ArrayList<Student> list1 = new ArrayList<>(); // 代表的な書き方です。「<>」はジェネリクスと呼ばれ、<>中に格納したいクラスの型名を記入します。
    ArrayList<Student> list2 = new ArrayList<Student>(); // 
    ArrayList list3 = new ArrayList(); // このような書き方をするとすべてのクラスを格納できますが、リストの中に何が入っているか不明確になります。
    AbstractList<Student> list4 = new ArrayList<>(); // ArrayList クラスは AbstractList を継承しているのでこのように書くことができます。
    List<Student> list5 = new ArrayList<>(); // ArrayList クラスは List インターフェースを実装しているのでこのように書くことができます。
    
    // 要素の追加
    list1.add(takeshi);
    list1.add(suneo);
    list1.add(shizuka);
    list1.add(nobita); // サイズが決まっていないため、のび太も仲間に入れられる。
    
    // サイズの取得と要素の取り出し
    int max = list1.size();
    for(int i=0; i<max; i++) {
      Student s = list1.get(i);
      System.out.println("ArrayList の " + i + " 番は " + s.getName() + " です。");
    }
    System.out.println();
    
    //　要素の削除
    int sizeOld = list1.size();
    list1.remove(3);
    for(Student s : list1) {
      System.out.println("名前 : " + s.getName());
    }
    int sizeNew = list1.size();
    System.out.println("削除前のサイズ : " + sizeOld + ", 削除後のサイズ : " + sizeNew);
    System.out.println("途中の要素を削除すると、その分配列が縮みます。");
    
    // 他の機能
    Student[] values1 = list1.toArray(new Student[0]); // Student 型の配列に変換 
    list1.addAll(list2); // 他のリストをまとめて追加
    // .... その他いろいろ
    
    
    System.out.println();
    
    
    // ●　HashMap クラス
    // 「キー」となるオブジェクトと「値」となるオブジェクトをセットで格納します。
    // 他のプログラム言語の、連想配列 と同じです。
    
    // 要素の追加
    HashMap<String, Student> map1 = new HashMap<String, Student>();
    map1.put("GodaTakeshi", takeshi);
    map1.put("HonekawaSuneo", suneo);
    map1.put("MinamotoShizuka", shizuka);
    map1.put("NobiNobita", nobita);
    
    // 要素の取り出し
    Student student1 = map1.get("HonekawaSuneo");
    System.out.println("Map に　HonekawaSuneo を渡して get すると " + student1.getName() + " が取得できる");
    
    // 要素を取り出して削除
    System.out.println("削除前のマップのサイズ : " + map1.size());
    Student student2 = map1.remove("NobiNobita");
    System.out.println("Map に　HonekawaSuneo を渡して remove すると " + student2.getName() + " が取得できる");
    System.out.println("削除後のマップのサイズ : " + map1.size());
    System.out.println();
    
    
    // ***********************************************
    // ★ 演習
    // Mini : 下のプログラムはリストの中から「骨川スネ夫」さん、「源静香」さんをみつけたら削除するプログラムです。
    //      : ただしこのプログラムは正しく動かず、「源静香」さんがリストに残ってしまいます。
    //      : どのように修正すればよいでしょうか。頭の中でシミュレーションしたり、デバッグをかけて修正してみてください。
    //
    // Full : HashSet, Stack, Queue の基本的な使い方や違いを調査してください。
    //      : その中の一つを選び、要素の追加と削除を行うサンプルコードを書いてください。
    //      : 解答のサンプルコードはそれぞれ Answer.java に載せられていますのでご確認ください。
    //
    // EX   : 取り組んでおられるEXがあれば、残りの時間で作業なさってください。
    // ***********************************************
    
    // *************************************************
    // Mini の例題
    ArrayList<Student> lstStudent = new ArrayList<>();
    lstStudent.add(takeshi);
    lstStudent.add(suneo);
    lstStudent.add(shizuka);
    lstStudent.add(nobita);
    
    
    System.out.println("削除前の名前リスト");
    for(Student s : lstStudent) {
      System.out.println("名前 : " + s.getName());
    }
    
    for(int i=0; i<lstStudent.size(); i++) {
      Student s = lstStudent.get(i);
      if(s.getName().equals("骨川スネ夫") || s.getName().equals("源静香")) {
        lstStudent.remove(i);
      }
    }
    
    System.out.println();
    System.out.println("削除後の名前リスト");
    for(Student s : lstStudent) {
      System.out.println("名前 : " + s.getName());
    }
    // *************************************************
    
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
