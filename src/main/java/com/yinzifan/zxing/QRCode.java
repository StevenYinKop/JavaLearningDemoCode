package com.yinzifan.zxing;

import static org.junit.Assert.*;

import java.awt.SystemColor;
import java.nio.file.FileSystems;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.beust.jcommander.internal.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCode {
	@Test
	public void qrCodeGenerator() throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("company", "KPMG");
		jsonObject.put("author", "steven");
		jsonObject.put("address", "Nanjing");
		jsonObject.put("position", "Java Engineer");
		int width = 300;
		int height = 300;
		String content = jsonObject.toString();
		Map<EncodeHintType, Object> hint = Maps.newHashMap();
		hint.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hint);
		MatrixToImageWriter.writeToPath(bitMatrix, "png", FileSystems.getDefault().getPath("QRCode" + System.currentTimeMillis() + ".png"));
	}
	
}
