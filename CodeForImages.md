# Code for turning an image to a byte array for later use

public byte[] ImageToByte(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			
			try {
				for (int i; (i = fis.read(buf)) != -1;) {
					bos.write(buf, 0, i);
					System.out.println("read " + i + " bytes, ");
				}
			}catch (IOException e) {
			}
			byte[] bytes = bos.toByteArray();
			return bytes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}