package HighSchool.CnData.BCA.util;

public class BCAEntry<V> {
	public String key = null;
	public V value = null;

	public BCAEntry(String key, V value)
	{
		this.key = key;
		this.value = value;
	}

	public boolean equals (Object o)
	{
		if (o instanceof String)
			return key.equals(o);

		else if (o instanceof BCAEntry)
			return key.equals(((BCAEntry)o).key);

		return false;
	}

	public String toString ()
	{
		return key + ": " + value;
	}
}
