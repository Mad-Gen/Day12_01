package example02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
    
    // ■ コレクションのその他の機能
    
    Student takeshi = new Student("剛田武", 1);
    Student suneo = new Student("骨川スネ夫", 2);
    Student shizuka = new Student("源静香", 3);
    Student nobita = new Student("野比のび太", 4);
    
    // 1. イテレーターを使ってArrayListのすべての要素にアクセスする
    ArrayList<Student> list1 = new ArrayList<>();
    list1.add(takeshi);
    list1.add(suneo);
    list1.add(shizuka);
    list1.add(nobita);
    
    //
    System.out.println("ArrayList の　Iterator による要素の取り出し");
    Iterator<Student> iter1 = list1.iterator();
    while(iter1.hasNext()) {
      Student s = iter1.next();
      System.out.println("名前 : " + s.getName());
      
      //if(s.getName().equals("骨側スネ夫")) {
      //  iter1.remove(); // iter.next() を呼び出した後、 iter.remove() で削除もできます。
      //}
    }
    
    
    
    // 2. イテレーターを使って HashMap のすべての要素にアクセスする
    HashMap<String, Student> map1 = new HashMap<>();
    map1.put(takeshi.getName(), takeshi);
    map1.put(suneo.getName(), suneo);
    map1.put(shizuka.getName(), shizuka);
    map1.put(nobita.getName(), nobita);
    
    //
    System.out.println("HashMap の keySet() を呼び出し、　Iterator を使ってすべてのキーを取り出し");
    Iterator<String> iter2 = map1.keySet().iterator();
    while(iter2.hasNext()) {
      String key = iter2.next();
      Student s = map1.get(key);
      System.out.println("名前 : " + s.getName());
    }
    
    
    
    // 3. オートボクシング
    // プリミティブ型を使用する際はラッパークラスを使います。
    // ラッパークラスは「クラス」なので参照型です
    // 
    // int <-> Integer
    // double <-> Double
    // boolean <-> Boolean
    // etc... ret:) https://www.javadrive.jp/start/var/index13.html
    
    List<Integer> list2 = new ArrayList<>(); // int 型を格納したい場合は Integer を指定する 
    for(int i=0; i<5; i++) {
      // プリミティブ型をそのまま指定すると、ラッパークラスに自動的に変換してくれる
      // 逆に ラッパークラス型 から プリミティブ型 への返還もしてくれます。
      
      //
      list2.add(i); 
      
      //
      int value = list2.get(i); 
      
      //
      System.out.println("要素 : " + value);
    }
    
    
    // 4. Collections, Arrays
    // コレクションや配列の便利機能が使えるユーティリティクラス
    List<String> list3 = Arrays.asList("Minamoto", "Nobi", "Goda", "Honekawa");
    //
    System.out.println();
    for(String s : list3) {
      System.out.println(s);
    }
    
    //
    System.out.println();
    Collections.sort(list3); // 並び替え
    for(String s : list3) {
      System.out.println(s);
    }
    
    System.out.println();
    Collections. reverse(list3); // 逆順
    for(String s : list3) {
      System.out.println(s);
    }
    
    
    // ***********************************************
    // ★ 演習
    // Mini : Collections の機能を使って、ArrayList に格納されている順番を逆にしてください。
    //
    // EX   : 取り組んでおられるEXがあれば、残りの時間で作業なさってください。
    // ***********************************************
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
