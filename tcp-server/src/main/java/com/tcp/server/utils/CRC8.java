package com.tcp.server.utils;

import java.util.zip.Checksum;

public class CRC8 implements Checksum {
	//private static final int poly = 0x0D5; // CRC-8/DVB-S2
	private static final int poly = 0x007; // CRC-8
	private int crc = 0;

	@Override
	public void update(final byte[] input, final int offset, final int len) {
		for (int i = 0; i < len; i++) {
			update(input[offset + i]);
		}
	}

	public void update(final byte[] input) {
		update(input, 0, input.length);
	}

	private final void update(final byte b) {
		crc ^= b;
		for (int j = 0; j < 8; j++) {
			if ((crc & 0x80) != 0) {
				crc = ((crc << 1) ^ poly);
			} else {
				crc <<= 1;
			}
		}
		crc &= 0xFF;
	}

	@Override
	public void update(final int b) {
		update((byte) b);
	}

	@Override
	public long getValue() {
		return (crc & 0xFF);
	}

	@Override
	public void reset() {
		crc = 0;
	}

	/**
	 * Test
	 */
	public static void main(String[] args) {
		CRC8 crc = new CRC8();

		//crc.update("1234".getBytes());
		//byte[] bytes = {9, 1, 49, 50, 51, 52};
		
		byte[] bytes1 = {0x0d, (byte) 0xa1, 0x6e, 0x65, 0x77, 0x20, 0x74, 0x65, 0x73, 0x74};
		byte[] bytes2 = {13, -95, 110, 101, 119, 32, 116, 101, 115, 116};
		byte[] bytes1Crc = {0x0d, (byte) 0xa1, 0x6e, 0x65, 0x77, 0x20, 0x74, 0x65, 0x73, 0x74, 0x19};
		
		crc.reset();
		crc.update(bytes1);
		System.out.println("Byte CRC: " + crc.getValue());
		System.out.println("Hex CRC: " + Integer.toHexString((int) crc.getValue()));
		crc.reset();
		crc.update(bytes1Crc);
		System.out.println("Byte CRC: " + crc.getValue());
		System.out.println("Hex CRC: " + Integer.toHexString((int) crc.getValue()));
	}

}
