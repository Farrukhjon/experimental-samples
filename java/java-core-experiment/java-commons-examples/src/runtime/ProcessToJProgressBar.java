package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessToJProgressBar {

	//private JTextArea textArea;
	private String command = "mysql -v --user=root --password=myroot007 finindex < C:\\Users\\Farrukhjon\\Desktop\\backup.sql";

	public ProcessToJProgressBar() throws IOException {
		Thread t = new Thread(UpdateProgressBar);
		t.start();
	}

	public static void main(String[] args) throws IOException {
		new ProcessToJProgressBar();
	}

	Runnable UpdateProgressBar = new Runnable() {

		@Override
		public void run() {
			/*final JDialog dlg = new JDialog();
			dlg.setTitle("Резервное копирование базы данных");
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			dlg.setSize(dim.width / 2, dim.height / 2);
			dlg.setVisible(true);
			dlg.setLocationRelativeTo(null);
			dlg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setAutoscrolls(true);
			DefaultCaret caret = (DefaultCaret) textArea.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			textArea.setCaret(caret);
			JScrollPane sp = new JScrollPane(textArea);
			JButton okBtn = new JButton("Закрыть");
			okBtn.setEnabled(false);
			JPanel pnl = new JPanel();
			pnl.add(okBtn, BorderLayout.CENTER);
			okBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dlg.dispose();
				}
			});
			dlg.add(sp, BorderLayout.CENTER);
			dlg.add(pnl, BorderLayout.SOUTH);
*/			try {
				//Process process = Runtime.getRuntime().exec("mysqldump -alv --user=root --password=myroot007 -B finindex -r backup.sql");
				Process process = Runtime.getRuntime().exec(command);
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String str;
				while ((str = reader.readLine()) != null) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//textArea.append(str + "\n");
					System.out.println(str);
					//dlg.validate();
				}
				//okBtn.setEnabled(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
}
