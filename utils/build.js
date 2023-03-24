import * as fs from 'fs';
import path from 'path';
import baekjunTemplate from './components/baekjun.js';
import programmersTemplate from './components/programmers.js';
import { getDomainDirList } from './getContents.js';

const __dirname = path.resolve(); // 현재 경로
const FILE_TO_UPDATE = path.resolve(__dirname, './README.md'); // Readme 파일 붙임
const DOMAINS = ['백준', '프로그래머스', 'SWEA'];

// 1. 각 도메인별 단계의 파일 수를 렌더링
const readmeHeader = `
# javascript-for-algorithm

프로그래머스, 백준, 삼성 SW 역량테스트 등 문제풀이를 백준허브를 이용해 저장하기 위한 레포지토리입니다.
`;

// 1.1 각 도메인 별 데이터 가져오기
const [baekjun, programmers, swea] = DOMAINS.map((domain) =>
  getDomainDirList(domain)
);

// 1.2 각 도메인 별 리드미 템플릿 빌드
const baekJunString = baekjunTemplate(baekjun);
const programmersString = programmersTemplate(programmers);
// const swea = () => {};

const updateData = [readmeHeader, baekJunString, programmersString].join('\n');

fs.writeFileSync(FILE_TO_UPDATE, updateData, 'utf-8');
