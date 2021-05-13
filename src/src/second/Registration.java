package second; // package

public interface Registration { // this interface store methods
    public  void Insert(int voter_id, String first_name, String last_name, String username, String password1, String email);
    public void Select(String username, String password);
    public void SelectForReg(int id);
}
