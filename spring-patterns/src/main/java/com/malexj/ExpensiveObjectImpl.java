package com.malexj;

import java.util.UUID;

public class ExpensiveObjectImpl implements ExpensiveObject {

  private static final String STATUS = "Processing complete";

  public ExpensiveObjectImpl() {
    printLogs(" >>> Init ExpensiveObjectImpl constructor!");
    heavyInitialConfiguration(UUID.randomUUID().toString());
  }

  @Override
  public String process() {
    /* .............................
     * do something, hard processing!
     * .............. Loading ......
     */
    printLogs(STATUS);
    return STATUS;
  }

  /**
   * Example: heavy Java object (like a JDBC connection or a SessionFactory) that requires some
   * initial configuration
   */
  private void heavyInitialConfiguration(String uuid) {
    printLogs(" >>> Loading initial configuration..." + uuid);
  }
}
