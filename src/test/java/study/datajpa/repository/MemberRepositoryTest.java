package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  void testMember() {
    Member member = new Member("memberA");

    Member savedMemeber = memberRepository.save(member);

    Member findMember = memberRepository.findById(savedMemeber.getId()).get();

    assertThat(findMember.getId()).isEqualTo(savedMemeber.getId());
    assertThat(findMember.getUsername()).isEqualTo(savedMemeber.getUsername());
    assertThat(findMember).isEqualTo(savedMemeber);
  }

}