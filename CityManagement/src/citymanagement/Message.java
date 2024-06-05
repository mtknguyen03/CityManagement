package citymanagement;

public class Message {
	private String method_name;
	private Object[] parameters;
	
	public Message(String method_name, Object[] parameters)
	{
		this.method_name = method_name;
		this.parameters = parameters;
	}
	
	
	public String getMethodName() {
        return method_name;
    }

    public Object[] getParameters() {
        return parameters;
    }
}
