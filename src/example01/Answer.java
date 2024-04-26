package example01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

public class Answer {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    // Mini の演習の解答
    arrayListProblem();
    
    // ハッシュセットの特徴
    //hashSet();
    
    // スタックの特徴
    //stackSample();
    
    // キューの特徴
    //queueSample();
  }
  
  /**
   * ミニマムサクセス
   */
  private static void arrayListProblem() {
    Student takeshi = new Student("剛田武", 1);
    Student suneo = new Student("骨川スネ夫", 2);
    Student shizuka = new Student("源静香", 3);
    Student nobita = new Student("野比のび太", 4);
    
    ArrayList<Student> lstStudent = new ArrayList<>();
    lstStudent.add(takeshi);
    lstStudent.add(suneo);
    lstStudent.add(shizuka);
    lstStudent.add(nobita);
    
    //
    System.out.println("削除前の名前リスト");
    for(Student s : lstStudent) {
      System.out.println("名前 : " + s.getName());
    }
    
    // ループカウンタを0から回した場合「骨川スネ夫」さんを削除すると、今まで「骨川スネ夫」があったIndexの位置に「源静香」さんがずれてきます。
    // 結果的に「源静香」のIndexの処理はすでに完了したことになってしまい、削除されません。
    //
    // 対策としてループカウンタを配列の後ろ側からカウントダウンしてあげることで処理できるようになります。 
    for(int i=lstStudent.size()-1; i>=0; i--) {
      Student s = lstStudent.get(i);
      if(s.getName().equals("骨川スネ夫") || s.getName().equals("源静香")) {
        lstStudent.remove(i);
      }
    }
    
    //
    System.out.println();
    System.out.println("削除後の名前リスト");
    for(Student s : lstStudent) {
      System.out.println("名前 : " + s.getName());
    }
  }

  /**
   * ハッシュセットのサンプル
   */
  private static void hashSet() {
    
    Student takeshi = new Student("剛田武", 1);
    Student suneo = new Student("骨川スネ夫", 2);
    Student shizuka = new Student("源静香", 3);
    Student nobita = new Student("野比のび太", 4);
    
    // HashSetのインスタンスを作成
    HashSet<Student> hashSet = new HashSet<>();

    // HashSetに要素を追加
    hashSet.add(takeshi);
    hashSet.add(suneo);
    hashSet.add(shizuka);
    hashSet.add(nobita);
    
    // ハッシュセットのサイズ
    System.out.println("nobita を追加する前のハッシュセットのサイズ : " + hashSet.size());

    // 重複を許さないため、同じ要素を追加しても無視される
    hashSet.add(nobita);
    
    // ハッシュセットのサイズ
    System.out.println("nobita を追加する後のハッシュセットのサイズ : " + hashSet.size());
    System.out.println("要素の重複が発生しないため、サイズが変わりません。");
  }
  
  /**
   * キューのサンプル
   */
  private static void queueSample() {
    
    // Java の Queue には様々な派生型があるため一番シンプルなサンプルを載せています。
    // 状況に合わせて、適切なクラスの使い方を調査してご利用ください。
    
    Student takeshi = new Student("剛田武", 1);
    Student suneo = new Student("骨川スネ夫", 2);
    Student shizuka = new Student("源静香", 3);
    Student nobita = new Student("野比のび太", 4);
    
    // Queueのインスタンスを作成
    Queue<Student> queue = new ArrayDeque<>();

    // Queueに要素を追加（offer）
    queue.add(takeshi);
    queue.add(suneo);
    queue.add(shizuka);
    queue.add(nobita);

    // Queueから要素を取り出す（ポール）し、表示する
    System.out.println("Poll メソッドを使って順番に取り出します。");
    while (!queue.isEmpty()) {
      Student s = queue.poll(); // poll() を行うと Queue からデータを削除してから取り出します。
      System.out.println(s.getName());
    }
    System.out.println("追加した順番でデータを取り出せます。");
  }
  
  /**
   * スタックのサンプル
   */
  private static void stackSample() {
    // Stackのインスタンスを作成
    Stack<Student> stack = new Stack<>();

    // Stackに要素を追加（プッシュ）
    stack.push(new Student("剛田武", 1));
    stack.push(new Student("骨川スネ夫", 2));
    stack.push(new Student("源静香", 3));

    // Stackから要素を取り出す（ポップ）し、表示する
    System.out.println("Pop メソッドを使ってデータを取り出します。");
    while (!stack.isEmpty()) {
      Student s = stack.pop(); // pop() を行うと stack からデータを削除してから取り出します。
      System.out.println(s.getName());
    }
    
    System.out.println("追加した時とは逆の順番でデータを取り出せます。");
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
