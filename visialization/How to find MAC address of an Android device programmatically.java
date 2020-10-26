****************************************
QUERY: How to find MAC address of an Android device programmatically?
****************************************

----------------------------------------
RANK 1
----------------------------------------
DESCRIPTION: findDeviceByMacAddress
CODE:
    public BluetoothDevice findDeviceByMacAddress(String macAddress) {
        for(BluetoothDevice device: getPairedDevices()) {
            if(device.getAddress().equalsIgnoreCase(macAddress)) {
                return device;
            }
        }
        return null;
    }


----------------------------------------

----------------------------------------
RANK 2
----------------------------------------
DESCRIPTION: getView
CODE:
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = mLayoutInflater.inflate(mViewResourceId, null);

        BluetoothDevice device = mDevices.get(position);

        if(device != null)
        {
            TextView deviceName = (TextView) convertView.findViewById(R.id.tvDeviceName);
            TextView deviceAddress = (TextView) convertView.findViewById(R.id.tvDeviceAddress);

            if(deviceName != null)
            {
                deviceName.setText(device.getName());
            }
            if(deviceAddress != null)
            {
                deviceAddress.setText(device.getAddress());
            }
        }

        return convertView;
    }
}

----------------------------------------

----------------------------------------
RANK 3
----------------------------------------
DESCRIPTION: get
CODE:
    public Device get(String address) {
        return getDeviceLibrary().getDeviceByAddress(address);
    }
}

----------------------------------------

----------------------------------------
RANK 4
----------------------------------------
DESCRIPTION: get
CODE:
    public Device get(String address) {
        return getDeviceLibrary().getDeviceByAddress(address);
    }
}

----------------------------------------

----------------------------------------
RANK 5
----------------------------------------
DESCRIPTION: setItem
CODE:
		public void setItem (BluetoothDevice device)
		{
			mDevice = device;

			mName.setText (device.getName ());
			mAddress.setText (device.getAddress ());
		}
	}

----------------------------------------

