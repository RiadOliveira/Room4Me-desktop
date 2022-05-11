package model.BO;

public interface IBaseBO<VO> {
	public abstract void insert(VO entity) throws Exception;
	public abstract void update(VO entity) throws Exception;
	public abstract void delete(VO entity) throws Exception;
	public abstract VO findById(VO entity);
}