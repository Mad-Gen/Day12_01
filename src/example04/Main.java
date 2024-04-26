package example04;

/**
 * 
 */
public class Main {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    // ■ マルチスレッド
    //
    // メリット
    //   ▶ 処理を高速化できる。CPUのコア数によっては数倍から数十倍のスピードアップも
    //
    // デメリット
    //   ▶ シングルスレッド（通常の処理）でうまく動いていることが前提
    //   ▶ スレッド間できちんと連携しないといけない（排他制御）
    //   ▶ デバッグが難しい
    //   ▶ 摩訶不思議なことが起こる
    //   ▶ きちんと動いたとしても、高速化できるとは限らない
    
    // 今回は細かい技術の話はしません。
    // まずはどのようにコーディングし、どのように動くか確認しましょう。
    
    
    // メソッドの中に以下のように書いてある クラスを 無名クラスといいます。
    // Java には Runnable という　interface があります。
    // Runnable には run() メソッドが 定義されているため クラスの中で run() を実装しています。
    // 
    // ただし下のクラスは r の変数にオブジェクトが代入されていますが、r.run()　としていないので
    // 内部の処理が実行されることはありません。ただクラスが定義され、インスタンス化されているだけです。
    //
    Runnable r = new Runnable() {
      public void run() {
        for(int i = 0; i < 10; i++){
          System.out.println("別スレッドで仕事をこなしています!! Step : " + (i+1));
          
          // そのままループを回すと一瞬で終わってしまうのでちょっとお休みを入れています。
          try { Thread.sleep(1000); } catch(Exception e) {
            // 例外はもみ消します。
          }
        }
      }
    };
    
    
    // マルチスレッドを使わず通常私たちが書いているプログラムは　メインスレッド で動いています。
    // 以下のように別のスレッドクラスをインスタンス化し start() を呼ぶことで サブスレッド を起動し実行できます。
    //
    Thread t = new Thread(r);
    t.start(); // スレッドを開始すると、このメソッドは一瞬で終了します。
    
    
    System.out.println("メインスレッドは最後まで実行されました！");
    System.out.println("--------------");
    
    
    // ***********************************************
    // ★ 演習
    // Mini : こちらのプログラムを「写経(そのまま書き写す)」してください。
    //      : 書き終えたら手元で実行してみましょう。
    // Full : 「メインスレッドは最後まで実行されました」の部分にブレークポイントを置いて、デバッグ実行してみてください。
    //      : デバッグ実行中も サブスレッド が動き続けていることを確認してください。
    //
    // Mini, Full とも上記のコードと同じなので解答サンプルはありません。 
    //
    // EX   : 取り組んでおられるEXがあれば、残りの時間で作業なさってください。
    // ***********************************************

  }
}