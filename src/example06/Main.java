package example06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  
  /**
   * 
   * @param args
   */
  public static void main(String[] args) {

    // ■ 排他制御
    // 図をご覧ください。
    
    ExecutorService exec = Executors.newCachedThreadPool();
    
    //
    ShareNote s_note = new ShareNote(0);
    
    System.out.println("10人で手分けして、入荷作業を行います。");
    System.out.println("入荷したら共有ノートの在庫数を更新します。");
    System.out.println();
    System.out.println("お仕事前の在庫数は : " + s_note.getStockCount() + " です。");
    System.out.println("業務開始!!");
    

    // スレッドプールに タスク を割り当て
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.execute(new ArrivalTask(s_note));
    exec.shutdown(); // タスクの割り当てが完了したら呼び出します。


    //
    try{
      exec.awaitTermination(60, TimeUnit.SECONDS); // タイムアウトを60秒に設定しています。
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    
    System.out.println("*******");
    System.out.println("すべての仕事が完了しました!!");
    System.out.println("お仕事完了後の在庫数は : " + s_note.getStockCount() + " です。");
    
    // ***********************************************
    // ★ 演習
    // Mini : こちらの例は排他制御の必要性を示すシンプルな例でした。
    //      : 排他制御をする際、他にどんなコーディング方法があるでしょうか？
    //      : また気を付けなければならないどんなことがありますか？
    //      : 調査してブレークアウトで共有し、Slackへ投稿してください。
    //
    // EX   : 取り組んでおられるEXがあれば、残りの時間で作業なさってください。
    // ***********************************************
  }

  /**
   * 入荷 管理クラス
   */
  private static class ArrivalTask implements Runnable{

    private ShareNote note = null;

    /**
     * コンストラクタ
     * @param _note
     */
    public ArrivalTask(ShareNote _note) {
      this.note = _note;
    }

    /**
     * 実際の処理
     */
    @Override
    public void run() {
      

      for(int i=0; i<100; i++) {
        this.note.unSyncIncrement();
        //this.note.syncIncrement();

        this.waiteTime();
      }
    }
    
    /**
     * 
     */
    private void waiteTime() {
      long time = (long)(Math.random() * 10);
      try { Thread.sleep(time); }catch(Exception e) {
        // 例外はもみ消します。
      }
    }
  }
  
  /**
   * 共有ノート
   */
  private static class ShareNote {
    private int countStock = 0;

    /**
     * コンストラクタ
     * @param stoke
     */
    public ShareNote(int stoke) {
      this.countStock = stoke;
    }
    
    /**
     * 在庫数を取得
     * @return
     */
    public int getStockCount() {
      return countStock;
    }    
    
    /**
     * シンクロナイズド付の在庫増加
     */
    public synchronized void syncIncrement() {
      countStock += 1;
      System.out.println("インクリメント後のカウント: " + countStock);
    }
    
    
    /**
     * シンクロナイズド無しの在庫増加
     */
    public void unSyncIncrement() {
      countStock += 1;
      System.out.println("インクリメント後のカウント: " + countStock);
    }
  }
}
