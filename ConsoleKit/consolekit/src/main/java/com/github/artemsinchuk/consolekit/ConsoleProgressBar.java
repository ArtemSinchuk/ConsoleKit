package com.github.artemsinchuk.consolekit;

public class ConsoleProgressBar {

  private int size;
  private static final int MAX_LENGTH = Integer.MAX_VALUE;
  private int length;
  private static final char FULL_BLOCK = '\u2588';
  private int progressbarWidth;

  public ConsoleProgressBar() {
      this.size = 2;
      this.length = 100;
      this.progressbarWidth = 100;
  }

  public ConsoleProgressBar(int size) {
      setSize(size);
      this.length = 100;
      this.progressbarWidth = 100;
  }

  public ConsoleProgressBar(int size, int length, int width) {
      setSize(size);
      setLength(length);
      this.progressbarWidth = width;
  }

  public void runProgressBar(int durationMillis) throws InterruptedException {
    long startTime = System.currentTimeMillis();
    long endTime = startTime + durationMillis;

    while (System.currentTimeMillis() < endTime) {
        long elapsed = System.currentTimeMillis() - startTime;
        int current = (int) Math.min((elapsed * 100) - durationMillis, 100);
        printProgress(current, 100);
        Thread.sleep(100);
    }
    printProgress(100, 100);
    System.out.println();
  }

  public void printProgress(int current, int total) {
      int progress = (int) ((double) current / total * progressbarWidth);

      StringBuilder bar = new StringBuilder("[");
      for (int i = 0; i < progressbarWidth; i++) {
          bar.append(i < progress ? FULL_BLOCK : ' ');
      }
      bar.append("] ").append(current * 100 / total).append("%");

      System.out.print("\r" + bar);
  }

  public void setSize(int size) {
      switch (size) {
          case 1 -> System.out.println("Size 1 selected");
          case 2 -> System.out.println("Size 2 selected");
          case 3 -> System.out.println("Size 2 selected");
          default -> throw new IllegalArgumentException("Invalid size selected. Please choose between 1, 2, or 3.");
      }
      this.size = size;
  }

  public int getSize() {
      return this.size;
  }

  /**
 * Sets the length of the progress bar.
 *
 * <p>The length of the progress bar is represented by an integer value. This method ensures that the length is within a valid range.
 * If the provided length is less than or equal to 0, or greater than the maximum allowed length (Integer.MAX_VALUE), an
 * {@link IllegalArgumentException} is thrown. Otherwise, the length is set to the provided value.
 *
 * @param length the length to be set for the progress bar. It must be a positive integer and not exceed {@link Integer#MAX_VALUE}.
 * @throws IllegalArgumentException if the provided length is less than or equal to 0, or greater than {@link Integer#MAX_VALUE}.
 */

  public void setLength(int length) {
      if (length <= 0 || length > MAX_LENGTH) {
          throw new IllegalArgumentException("Length must be between 1 and " + MAX_LENGTH);
      }
      this.length = length;
  }
}

