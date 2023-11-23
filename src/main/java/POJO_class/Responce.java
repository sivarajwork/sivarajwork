package POJO_class;

import java.util.ArrayList;
import java.util.List;

public class Responce {

private Boolean _isSucceed;
private ArrayList<_data> _data;
private String _msg;

public Boolean get_isSucceed() {
	return _isSucceed;
}
public void set_isSucceed(Boolean _isSucceed) {
	this._isSucceed = _isSucceed;
}
public ArrayList<_data> get_data() {
	return _data;
}
public void set_data(ArrayList<POJO_class._data> _data) {
	this._data = _data;
}
public String get_msg() { 
	return _msg;
}
public void set_msg(String _msg) {
	this._msg = _msg;
}


}
