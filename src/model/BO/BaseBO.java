package model.BO;

public abstract class BaseBO<VO> {
	public abstract void insert(VO entity) throws Exception;
	public abstract void update(VO entity) throws Exception;
	public abstract void delete(VO entity) throws Exception;
	public abstract VO findById(VO entity);

	protected void verifyIsNull(VO entity) throws Exception {
		if(entity == null) {
			String entityName = this.getClass().getSimpleName().split("BO")[0];
			throw new Exception(entityName + " can't be null.");
		}
	}
}