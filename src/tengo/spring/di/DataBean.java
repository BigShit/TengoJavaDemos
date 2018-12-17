package tengo.spring.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* ���bean������һ�Ѽ������ݣ���Щ���ݺ���Ҫͨ��xml�ļ����� */
public class DataBean {

	// һ����ͨ�ļ���
	List addressList;
	// ȥ�صļ���
	Set addressSet;
	// ��ֵ�Լ���
	Map addressMap;
	// ��hashtableʵ�ֵ�
	Properties addressProp;

	public List getAddressList() {
		return addressList;
	}

	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}

	public Set getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}

	public Map getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}

	public Properties getAddressProp() {
		return addressProp;
	}

	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}

}
