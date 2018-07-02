package kolas3.common.paging;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PagingBoard {
	private boolean isPrevPage;
	private boolean isNextPage;
	protected int nowPage;
	protected int rowTotal;
	protected int blockList;
	protected int blockPage;
	protected int blockSize;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public PagingBoard(int nowPage, int rowTotal, int blockList, int blockPage) {
		this.isPrevPage = false;
		this.isNextPage = false;

		this.totalPage = ((int) Math.ceil(rowTotal / blockList));
		if (nowPage > this.totalPage) {
			nowPage = this.totalPage;
		}
		this.startRow = ((nowPage - 1) * blockList);
		this.endRow = (this.startRow + blockList - 1);

		this.startPage = ((nowPage - 1) / blockPage * blockPage + 1);
		this.endPage = (this.startPage + blockPage - 1);
		if (this.endPage > this.totalPage) {
			this.endPage = this.totalPage;
		}
		if (this.startPage > 1) {
			this.isPrevPage = true;
		}
		if (this.endPage < this.totalPage) {
			this.isNextPage = true;
		}
		this.nowPage = nowPage;
		this.rowTotal = rowTotal;
		this.blockList = blockList;
		this.blockPage = blockPage;
	}

	public void Debug() {
		for (int i = this.startPage; i <= this.endPage; i++) {
			if (i == this.nowPage) {
				System.out.print("<" + i + ">");
			} else {
				System.out.print("[" + i + "]");
			}
		}
		logger.debug("");
		logger.debug("Total Page : " + this.totalPage + " / Start Page : " + this.startPage + " / End Page : "
				+ this.endPage);
		logger.debug(
				"Total Row : " + this.rowTotal + " / Start Row : " + this.startRow + " / End Row : " + this.endRow);
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public int getStartRow() {
		return this.startRow;
	}

	public int getEndRow() {
		return this.endRow;
	}

	public int getBlockSize() {
		return this.blockSize;
	}

	public int getStartPage() {
		return this.startPage;
	}

	public int getEndPage() {
		return this.endPage;
	}

	public boolean isPrevPage() {
		return this.isPrevPage;
	}

	public boolean isNextPage() {
		return this.isNextPage;
	}
}
