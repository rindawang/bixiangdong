package com.piped.stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedSteam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PipedInputStream input = new PipedInputStream();
		PipedOutputStream output = new PipedOutputStream();
		input.connect(output);
		
		new Thread(new Input(input)).start();
		new Thread(new Output(output)).start();
	}
	
}

class Input implements Runnable{
	
	private PipedInputStream in;
	
	Input(PipedInputStream in){
		this.in = in;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String s = new String(buf, 0, len);
			System.out.println("s = " + s);
			in.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}

class Output implements Runnable{
	private PipedOutputStream out;
	Output(PipedOutputStream out){
		this.out = out;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			out.write("嘿！ 管道來了！！！".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}