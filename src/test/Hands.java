package test;

import java.util.Random;

/**
 * ジャンケンの手
 */
public enum Hands {
  /** グー */
  Rock("グー", 0),
  /** チョキ */
  Scissors("チョキ", 1),
  /** パー */
  Paper("パー", 2);

  /** 表示文字 */
  private final String display;
  /** 内部番号 */
  private final int number;

  /**
   * コンストラクタ
   *
   * @param display 表示名
   * @param number  番号
   */
  Hands(String display, int number) {
    this.display = display;
    this.number = number;
  }

  /**
   * ランダムな手を生成
   *
   * @return ランダムに生成した手
   */
  public static Hands getRandomHand() {
    Random rand = new Random();
    return Hands.values()[rand.nextInt(3)];
  }

  /**
   * 表示名を取得
   *
   * @return 表示名
   */
  public String getDisplay() {
    return this.display;
  }

  /**
   * 番号を取得
   *
   * @return 番号
   */
  public int getNumber() {
    return this.number;
  }
}