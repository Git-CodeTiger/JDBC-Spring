package studio.codeocean.common;

import java.util.Map;
import java.util.HashMap;

public class Result {
	private Map status = new HashMap();
	private Object result;

	public Result() {
		this.status.put("code", 1);
		this.status.put("message", "操作成功");
	}

	public void setStatus(int code, String message) {
		this.status.put("code", code);
		this.status.put("message", message);
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Map getStatus() {
		return status;
	}

	public Object getResult() {
		return result;
	}
}
