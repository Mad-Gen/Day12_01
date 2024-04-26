package example05;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Answer {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    // 以下は一例です。
    //
    // Future f = exec.submit(task);
    // f.get()
    // などを使うこともできます。
    
    ExecutorService exec = Executors.newCachedThreadPool();
    //ExecutorService exec = Executors.newFixedThreadPool(2); // このようにすると指定した数のスレッドで実行できます。

    // スレッドプールに タスク を割り当て
    exec.execute(new Task("皿洗い"));
    exec.execute(new Task("------お片付け"));
    exec.execute(new Task("-------------お風呂掃除"));
    exec.shutdown(); // タスクの割り当てが完了したら呼び出します。
    
    System.out.println("メインスレッド（タスクの割り当て人）の仕事は完了しました。");
    System.out.println("*******");
    
    //
    try{
      exec.awaitTermination(60, TimeUnit.SECONDS); // タイムアウトを60秒に設定しています。
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    
    System.out.println("*******");
    System.out.println("すべての仕事が完了しました!!");
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
