package test;

import java.io.ObjectInputFilter.Status;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ゲームのメイン画面
 */
public class MainWindow {

  /**
   * ゲームを表示するフレーム
   */
  private final JFrame frame;

  /**
   * メッセージを表示するラベル
   */
  private final JLabel messageLabel;

  /**
   * グー　のボタン
   */
  private final JButton rockButton;

  /**
   * チョキ　のボタン
   */
  private final JButton scissorsButton;

  /**
   * パー　のボタン
   */
  private final JButton paperButton;

  /**
   * プレイ状況のステータス
   */
  private Status playState;

  /**
   * 相手が出した手
   */
  private Hands opponentHand;

  /**
   * コンストラクタ
   */
  public MainWindow() {
    // 画面生成
    this.frame = new JFrame("じゃんけんゲーム！");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 画面サイズを指定
    this.frame.setBounds(200, 200, 600, 400);

    var pane = this.frame.getContentPane();

    // このcanvasに対して、ボタンやラベルを配置していく
    var canvas = new JPanel();
    // 自由レイアウトに変更する
    canvas.setLayout(null);

    // ラベル
    this.messageLabel = new JLabel("じゃーんけーん・・・");
    this.messageLabel.setBounds(20, 20, 400, 30);
    canvas.add(this.messageLabel);

    // --------------
    // ボタンを作成する
    // --------------

    // グー
    this.rockButton = new JButton(Hands.Rock.getDisplay());
    this.rockButton.setBounds(100, 100, 100, 40);
    this.rockButton.addActionListener((e) -> this.selectHand(Hands.Rock));
    canvas.add(this.rockButton);

    // チョキ
    this.scissorsButton = new JButton(Hands.Scissors.getDisplay());
    scissorsButton.setBounds(250, 100, 100, 40);
    this.scissorsButton.addActionListener((e) -> this.selectHand(Hands.Scissors));
    canvas.add(scissorsButton);

    // パー
    this.paperButton = new JButton(Hands.Paper.getDisplay());
    paperButton.setBounds(400, 100, 100, 40);
    this.paperButton.addActionListener((e) -> this.selectHand(Hands.Paper));
    canvas.add(paperButton);

    // 画面にCanvasを追加
    pane.add(canvas);
  }

  /**
   * 画面表示
   */
  public void show() {
    this.init();
    this.frame.setVisible(true);
  }

  /**
   * ゲームの初期化
   */
  public void init() {
    // 相手の手をリセットし、待ち状態にする
    this.opponentHand = Hands.getRandomHand();
    this.playState = Status.ALLOWED;
  }

  /**
   * 自分の手を選んだ時の処理
   *
   * @param selected 選択した手
   */
  public void selectHand(Hands selected) {

    // 入力待ちでなければ以降の処理はしない
    if (this.playState != Status.ALLOWED) {
      return;
    }

    // 勝ち負けの判定
    switch ((selected.getNumber() - opponentHand.getNumber() + 3) % 3) {
      case 0:
        // 引き分けなので継続
        this.messageLabel.setText("あーいこーで・・・");
        // 手を出しなおす
        this.init();
        break;
      case 1:
        // 負け
        this.messageLabel.setText(String.format("相手が出したのは「%s」なのであなたの負けです。", this.opponentHand.getDisplay()));
        // ゲーム終了
        this.playState = Status.ALLOWED;
        break;
      case 2:
        this.messageLabel.setText(String.format("相手が出したのは「%s」なのであなたの勝ちです。", this.opponentHand.getDisplay()));
        // ゲーム終了
        this.playState = Status.ALLOWED;
        break;
    }
  }}


