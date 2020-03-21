package ssm.dao;


import ssm.domain.Items;

public interface ItemsDao {
    public Items findById(Integer id);
}
