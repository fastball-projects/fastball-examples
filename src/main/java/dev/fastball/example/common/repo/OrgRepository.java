package dev.fastball.example.common.repo;

import dev.fastball.example.common.model.Org;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static dev.fastball.example.common.dict.OrgType.*;

/**
 * @author gr@fastball.dev
 * @since 2023/1/8
 */
@Component
public class OrgRepository extends MockRepo<Org> {
    public Collection<Org> findRootAndLoadSubOrg() {
        return data.values().stream().filter(org -> org.getParentId() == null).map(Org::new).map(this::loadSubOrg).collect(Collectors.toList());
    }

    public Collection<Org> findRoot() {
        return data.values().stream().filter(org -> org.getParentId() == null).collect(Collectors.toList());
    }

    public List<Org> findByParentId(Integer parentId) {
        return data.values().stream().filter(org -> Objects.equals(parentId, org.getParentId())).collect(Collectors.toList());
    }

    private Org loadSubOrg(Org org) {
        org.setSubOrg(findByParentId(org.getId()));
        org.getSubOrg().forEach(this::loadSubOrg);
        return org;
    }

    @Override
    protected int initMaxId() {
        return 10100000;
    }

    @Override
    protected Org[] initData() {
        return new Org[]{
                Org.builder().id(10000001).name("XX 集团").type(Group).build(),
                Org.builder().id(10000011).parentId(10000001).name("XX 公司").type(Group).build(),
                Org.builder().id(10000012).parentId(10000001).name("YY 公司").type(Company).build(),
                Org.builder().id(10000121).parentId(10000012).name("XX 研发部").type(Department).build(),
                Org.builder().id(10000122).parentId(10000012).name("XX 运营部").type(Department).build()
        };
    }
}
