package com.yinzifan.lucene;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class LuceneFirst {

	public static void createIndex() throws IOException {
		// 1. 创建一个Directory对象, 指定索引库的保存位置
//		Directory directory = new RAMDirectory();
		Path path = new File("index").toPath();
		Directory directory = FSDirectory.open(path);
		// 2. 基于Director对象创建一个IndexWriter对象.
		IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig());
		
		
		// 3. 读取磁盘上的文件, 对应每个文件创建一个文档对象.
		File f = new File("pride-and-prejudice.txt");
		String fileStr = FileUtils.readFileToString(f, "UTF-8");
		String filePath = f.getPath();
		String fileName = f.getName();
		long size = FileUtils.sizeOf(f);
		// 4 向文档对象中添加域
		Field fieldName = new TextField("name", fileName, Field.Store.YES);
		Field fieldPath = new TextField("path", filePath, Field.Store.YES);
		Field fieldContent = new TextField("content", fileStr, Field.Store.YES);
		Field fieldSize = new TextField("size", size + "", Field.Store.YES);
		// 5 把文档写入索引库
		Document document = new Document();
		document.add(fieldName);
		document.add(fieldPath);
		document.add(fieldContent);
		document.add(fieldSize);
		// 6. 关闭IndexWriter对象
		indexWriter.addDocument(document);
		indexWriter.close(); 
	}
	
	public static void readIndex() throws IOException {
		// 1 创建一个Directory对象, 指定索引库的位置
		Path path = new File("index").toPath();
		Directory directory = FSDirectory.open(path);
		// 2 创建一个IndexReader对象
		IndexReader indexReader = DirectoryReader.open(directory);
		// 3 创建一个IndexSearcher对象, 构造方法中的参数indexReader对象
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		// 4 创建一个Query对象, TermQuery
		Query query = new TermQuery(new Term("content", "pride"));
		// 5 执行查询, 得到一个TopDocs对象
		TopDocs topDocs = indexSearcher.search(query, 10);
		// 6 取查询结果的总记录数
		long total = topDocs.totalHits;
		System.out.println(total);
		// 7 取文档列表
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		// 8 打印文档内容
		for (ScoreDoc scoreDoc : scoreDocs) {
			int doc = scoreDoc.doc;
			Document document = indexSearcher.doc(doc);
			System.out.println(document.get("name"));
			System.out.println(document.get("path"));
			System.out.println(document.get("size"));
//			System.out.println(document.get("content"));
			System.out.println("********************************");
		}
		// 9 关闭IndexReader对象
		indexReader.close();
	}
	
	public static void main(String[] args) throws IOException {
		readIndex();
	}
}
