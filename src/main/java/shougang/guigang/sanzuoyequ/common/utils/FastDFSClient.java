package shougang.guigang.sanzuoyequ.common.utils;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {
	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer = null;
	private StorageClient1 storageClient = null;
	
	public FastDFSClient(String conf) throws IOException, MyException {
		if(conf.contains("classpath:")){
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
		}
		ClientGlobal.init(conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageServer = null;
		storageClient = new StorageClient1(trackerServer , storageServer);
	}
	
	/**
	 * The method of uploading files
	 * @param fileName:the absolute path of file
	 * @param extName:the suffix of file
	 * @param metas:the informance of extending
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public String uploadFile(String fileName , String extName , NameValuePair[] metas) throws IOException, MyException{
		String result = storageClient.upload_file1(fileName, extName, metas);
		return result;
	}
	
	public String uploadFile(String fileName , String extName) throws IOException, MyException{
		String result = storageClient.upload_file1(fileName, extName, null);
		return result;
	}
	
	public String uploadFile(String fileName) throws IOException, MyException{
		String result = storageClient.upload_file1(fileName, null, null);
		return result;
	}
	
	/**
	 * The method of uploading files
	 * @param fileName:the content of file,byte array
	 * @param extName:the suffix of file
	 * @param metas:the informance of extending
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public String uploadFile(byte[] fileContent , String extName , NameValuePair[] metas) throws IOException, MyException{
		String result = storageClient.upload_file1(fileContent, extName, metas);
		return result;
	}
	
	public String uploadFile(byte[] fileContent , String extName) throws IOException, MyException{
		String result = storageClient.upload_file1(fileContent, extName, null);
		return result;
	}
	
	public String uploadFile(byte[] fileContent) throws IOException, MyException{
		String result = storageClient.upload_file1(fileContent, null, null);
		return result;
	}
	
}
