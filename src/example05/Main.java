package example05;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    // ■ スレッドプール
    // 別スレッドを使うたびに Thread t = new　Thread() を呼び出すのではなく
    // スレッドを必要な時に利用し、使い終わったら「プール」しておくことで効率を上げる方法です。
    
    ExecutorService exec = Executors.newCachedThreadPool();
    //ExecutorService exec = Executors.newFixedThreadPool(2); // このようにすると指定した数のスレッドで実行できます。
    
    // スレッドプールに タスク を割り当て
    exec.execute(new Task("皿洗い"));
    exec.execute(new Task("------お片付け"));
    exec.execute(new Task("-------------お風呂掃除"));
    exec.shutdown(); // タスクの割り当てが完了したら呼び出します。
    
    
    System.out.println("メインスレッド（タスクの割り当て人）の仕事は完了しました。");
    System.out.println("*******");
    
    
    // ***********************************************
    // ★ 演習
    // Mini : こちらのプログラムを「写経(そのまま書き写す)」してください。
    //      : 書き終えたら手元で実行してみましょう。
    //
    // FULL : 上記のプログラムは メインスレッド が サブスレッド の終了を待機せずに勝手に処理を終えてしまいます。
    //      : メインスレッド ですべてのタスクの終了を待機し、最後に「すべての仕事が終了しました」とメッセージを出すにはどうすればよいでしょうか。
    //      : GoogleやChatGPTで検索してコードを修正してください。
    //
    // EX   : 取り組んでおられるEXがあれば、残りの時間で作業なさってください。
    // ***********************************************
    
  }
  
  /**
   * スレッドに処理させる タスク クラス
   * 必ず Runnable を実装します。
   */
  private static class Task implements Runnable{
    
    private String name = null;
    
    /**
     * コンストラクタ
     * @param _name
     */
    public Task(String _name) {
      this.name = _name;
    }

    /**
     * 実際の処理
     */
    @Override
    public void run() {
      Random rand = new Random();
      
      for(int i=0; i<5; i++) {
        System.out.println(name + " を実行中。 Step : " + (i+1));
      
        // 1000 ～ 3000 の間で乱数を生成
        long time = (rand.nextInt(2000) + 1000);
        
        try { Thread.sleep(time); }catch(Exception e) {
          // 例外はもみ消します。
        }
      }
    }
  }
  
}
